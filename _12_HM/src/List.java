import java.io.File;

public class List {
    public static void main(String[] args){
        String catalogName="src";
        File catalog=new File(catalogName);

        if (catalog.isDirectory()){
            System.out.println("Папка "+catalogName );
            String[] list=catalog.list();
            if (list!=null){
                for (String fileName :list){
                    File file=new File(catalogName+"/"+fileName);
                    if(file.isDirectory()){
                        System.out.println(" каталог "+ fileName);
                    }else {
                        System.out.println(" файл "+ fileName);
                    }
                }
            }
        }
    }

}
