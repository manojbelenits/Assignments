import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {


        FileData fileData = new FileData("EmployeesData", "hgh",
                            2d, "About Their salary", "HR");

        FileProcessor csvFileProcessor = filedata -> {
            System.out.println("CSV Processor Selected ");
        };


        FileProcessor jsonFileProcessor = filedata -> {
            System.out.println("JSON Processor Selected ");
        };

        FileProcessor xmlFileProcessor = filedata -> {
            System.out.println("XML Processor Selected ");
        };

       FileProcessor txtFileProcessor = filedata -> {
           System.out.println("Txt Processor Selected ");
       };

        Map<String,FileProcessor> map = Map.of(
               "CSV",csvFileProcessor,
                "JSON",jsonFileProcessor,
                "XML",xmlFileProcessor,
                "TXT",txtFileProcessor
        );


        Predicate<FileData> fileSizeValidation = filedata ->filedata.getFileSizeInMb()<5;

        Predicate<FileData> fileTypeValidation = filedata->{
            String fileType = filedata.getFileType();

            if(fileType.equalsIgnoreCase("CSV") || fileType.equalsIgnoreCase("JSON")
            ||fileType.equalsIgnoreCase("XML") || fileType.equalsIgnoreCase("TXT")){
                return true;
            }
            return false;
        };

        Predicate<FileData> contentValidation = filedata->!filedata.getContent().isBlank();

        Predicate<FileData> userValidation = filedata->!filedata.getUploadedBy().isBlank();


        Predicate<FileData> allValid = fileSizeValidation
                                .and(fileTypeValidation)
                                .and(contentValidation)
                                .and(userValidation);


        BiConsumer<String, String> statusLogger = (status, message) ->
                System.out.println(status + " : " + message);

        if (allValid.test(fileData)) {

            Consumer<FileData> fileDetails = filedata -> {
                System.out.println("File Name : " + filedata.getFileName());
                System.out.println("File Type : " + filedata.getFileType());
                System.out.println("Size      : " + filedata.getFileSizeInMb() + " MB");
            };

            fileDetails.accept(fileData);

            FileProcessor fileProcessor = map.get(fileData.getFileType());

            if (fileProcessor != null) {

                fileProcessor.process(fileData);

                statusLogger.accept(
                        "SUCCESS",
                        fileData.getFileType() + " Records Processed Successfully"
                );

            } else {

                statusLogger.accept(
                        "FAILED",
                        "No Processor Found For File Type : " + fileData.getFileType()
                );
            }

        } else {

            statusLogger.accept(
                    "FAILED",
                    "Validation Failed"
            );
        }


    }
}



























