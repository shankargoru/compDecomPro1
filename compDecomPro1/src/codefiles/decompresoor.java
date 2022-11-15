package codefiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompresoor {
    public static void method(File file) throws IOException {
        String fileDirectory=file.getParent();
        System.out.print(fileDirectory);
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzpis=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(fileDirectory+"\\Decompressedfile.txt");
        byte[]buffer=new byte[1024];
        int len;
        while((len=gzpis.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzpis.close();
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        File path=new File("C:\\Users\\91817\\Desktop\\compressedfile.gz");
    }
}
