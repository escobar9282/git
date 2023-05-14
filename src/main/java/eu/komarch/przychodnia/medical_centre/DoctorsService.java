package eu.komarch.przychodnia.medical_centre;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorsService
{
    private final NameDataResolver dataResolver;

    @SneakyThrows
    public void resolveDoctorsData(MultipartFile menNames, MultipartFile menLastNames, MultipartFile womenNames, MultipartFile womenLastNames)
    {
        List<String> listData = new ArrayList<>();
        List<MultipartFile> files = List.of(menNames, menLastNames, womenNames, womenLastNames);
        for(MultipartFile multipartFile : files)
        {
            try(Workbook workbook = new XSSFWorkbook(multipartFile.getResource().getInputStream())) {
                Sheet shit = workbook.getSheet("Arkusz1");
                for (Row row : shit) {
                    for (Cell cell : row) {
                        listData.add(cell.getRichStringCellValue().getString());
                        break;
                    }
                }
            }
            listData.add("---");
        }
        List<NameDataPojo> dataPojos = goToDatabase(listData);
    }
    private List<NameDataPojo> goToDatabase(List<String> data)
    {
        List<String> listWomenNames = new ArrayList<>();
        List<String> listWomenLastNames = new ArrayList<>();
        int place = data.indexOf("---");
        List<String> listMenNames = data.subList(0, place+1);
        removeAllSubList(data, listMenNames);
        List<String> listMenLastNames = data.subList(0,place+1);

        return dataResolver.generatedData(listMenNames, listMenLastNames, listWomenNames, listWomenLastNames);
    }

    private void removeAllSubList(List<?> list, List<?> subList) {
        int i = Collections.indexOfSubList(list, subList);
        if (i != -1) {
            list.subList(i, i + subList.size()).clear();
            removeAllSubList(list.subList(i, list.size()), subList);
        }
    }

}
