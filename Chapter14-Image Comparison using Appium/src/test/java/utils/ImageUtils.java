package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Year: 2018-19
 *
 * @author Prat3ik on 16/01/19
 * @project Image Comparision Appium
 */
public class ImageUtils {

    public static String getBase64FormatOfImageFromURL(String URL) throws IOException, URISyntaxException {
        java.net.URL url = new URL(URL);
        try {
            InputStream is = url.openStream();
            byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(is);
            return org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Please check the network on your server! It seems disconnected.");
        }
    }

    /**
     * This method is used to convert Image(.png file) to Base64 String format.
     *
     * @param imgName
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String getBase64StringFormatOfImage(String imgName) throws URISyntaxException, IOException {

        System.out.println("ImgName:" + imgName);
        URL refImgUrl = ImageUtils.class.getClassLoader().getResource(imgName);

        System.out.println("URL:::" + refImgUrl);
        File refImgFile = Paths.get(refImgUrl.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    /**
     * This method is used to convert Image(.png file) to Base64 Byte format.
     *
     * @param imgName
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static byte[] getBase64ByteFormatOfImage(String imgName) throws URISyntaxException, IOException {
        URL refImgUrl = ImageUtils.class.getClassLoader().getResource(imgName);
        File refImgFile = Paths.get(refImgUrl.toURI()).toFile();
        return Files.readAllBytes(refImgFile.toPath());
    }

}
