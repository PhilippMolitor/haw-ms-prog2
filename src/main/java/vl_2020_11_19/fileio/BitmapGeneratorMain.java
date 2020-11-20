package vl_2020_11_19.fileio;

import java.io.File;
import java.io.FileOutputStream;

public class BitmapGeneratorMain {
    public static void main(String[] args) {
        BitmapGenerator bg = null;
        int sizeX = 256;
        int sizeY = 256;

        // try to create an image handle
        try {
            bg = new BitmapGenerator(sizeX, sizeY);
        } catch (Exception ex) {
            System.out.println("unable to create new image!");
            ex.printStackTrace();
            System.exit(1);
        }

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                byte r = mapToByte(x, 0, sizeX);
                byte g = mapToByte(y, 0, sizeY);
                byte b = mapToByte(sizeY - y, 0, sizeY);
                bg.setPixelRgb(x, y, r, g, b);
            }
        }

        // save file
        try {
            File f = new File("output_generator.bmp");
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bg.getImageAsBytes());
            fos.flush();
            fos.close();
            System.out.println("image was saved!");
        } catch (Exception ex) {
            System.out.println("failed to save image:");
            ex.printStackTrace();
        }
    }

    public static byte mapToByte(int in, int from, int to) {
        return (byte) ((in - from) * 255 / (to - from));
    }
}
