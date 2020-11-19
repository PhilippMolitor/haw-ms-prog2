package vl_2020_11_19.fileio;

import java.io.FileWriter;

public class BitmapGeneratorMain {
    public static void main(String[] args) {
        BitmapGenerator bg = null;
        int sizeX = 4;
        int sizeY = 4;

        // try to create an image handle
        try {
            bg = new BitmapGenerator(sizeX, sizeY);
        } catch (Exception ex) {
            System.out.println("unable to create new image!");
            ex.printStackTrace();
            System.exit(1);
        }

        for (int x = 0; x < sizeX; x++)
            for (int y = 0; y < sizeY; y++)
                bg.setPixelRgb(x, y, (byte) 0xff, (byte) 0xff, (byte) 0xff);

        // save file
        try {
            FileWriter fw = new FileWriter("output_generator.bmp");
            fw.write(new String(bg.getImageAsBytes(), "UTF-8").toCharArray());
            fw.flush();
            fw.close();
            System.out.println("image was saved!");
        } catch (Exception ex) {
            System.out.println("failed to save image:");
            ex.printStackTrace();
        }
    }
}
