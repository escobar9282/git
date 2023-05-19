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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorsService
{
    private final NameDataResolver dataResolver;

    @SneakyThrows
    public void resolveDoctorsData(MultipartFile menNames, MultipartFile menLastNames, MultipartFile womenNames, MultipartFile womenLastNames, MultipartFile personalIdentificationNumbers)
    {
        List<List<String>> listData = new ArrayList<>();
        List<MultipartFile> files = List.of(womenNames, womenLastNames, menNames, menLastNames);
        for(MultipartFile multipartFile : files)
        {
            List<String> nestedList = new ArrayList<>();
            try(Workbook workbook = new XSSFWorkbook(multipartFile.getResource().getInputStream())) {
                Sheet shit = workbook.getSheet("Arkusz1");
                for (Row row : shit) {
                    for (Cell cell : row) {
                        nestedList.add(cell.getRichStringCellValue().getString());
                        break;
                    }
                }
            }
            listData.add(nestedList);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(personalIdentificationNumbers.getInputStream()));
        listData.add(bufferedReader.lines().toList());
        List<NameDataPojo> dataPojos = goToDatabase(listData);
    }
    private List<NameDataPojo> goToDatabase(List<List<String>> data)
    {
        List<String> listWomenNames = data.get(0);
        List<String> listWomenLastNames = data.get(1);
        List<String> listMenNames = data.get(2);
        List<String> listMenLastNames = data.get(3);
        List<String> personalIdentificationNumbers = data.get(4);

        return dataResolver.generatedData(listMenNames, listMenLastNames, listWomenNames, listWomenLastNames, personalIdentificationNumbers);
    }
}
