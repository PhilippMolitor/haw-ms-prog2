package vl_2020_11_19.fileio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class BitmapGenerator {
    private final int sizeX;
    private final int sizeY;
    private final byte[] fileHeaderData;
    private final byte[] bitmapHeaderData;
    private final byte[] imageData;

    public BitmapGenerator(int sizeX, int sizeY) throws Exception {
        if (sizeX <= 0 || sizeY <= 0) {
            throw new Exception("bitmap must be at least 1x1 pixels.");
        }

        // size properties
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        imageData = new byte[sizeX * sizeY * 3];
        Arrays.fill(imageData, (byte) 0);

        // headers
        fileHeaderData = getFileHeader();
        bitmapHeaderData = getBitmapHeader();
    }

    public void setPixelRgb(int x, int y, byte r, byte g, byte b) throws InvalidParameterException {
        checkImageBounds(x, y);

        int baseIndex = sizeX * y + x;
        imageData[baseIndex] = b;
        imageData[baseIndex + 1] = g;
        imageData[baseIndex + 2] = r;
    }

    public void setPixelGrayscale(int x, int y, byte k) throws InvalidParameterException {
        checkImageBounds(x, y);

        int baseIndex = sizeY * y + x;
        imageData[baseIndex] = k;
        imageData[baseIndex + 1] = k;
        imageData[baseIndex + 2] = k;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public byte[] getImageAsBytes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // concatenate output bytes (headers + image data)
        try {
            outputStream.write(fileHeaderData);
            outputStream.write(bitmapHeaderData);
            outputStream.write(imageData);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }

    private void checkImageBounds(int x, int y) throws InvalidParameterException {
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY) {
            throw new InvalidParameterException("invalid pixel, please choose a pixel within the bitmap size.");
        }
    }

    private byte[] getFileHeader() {
        int size = 14 + 40 + (sizeX * sizeY * 3);

        return new byte[]{
                // magic header
                'B', 'M',
                // file size (reverse order)
                (byte) size, (byte) (size >>> 8), (byte) (size >>> 16), (byte) (size >>> 24),
                // reserved
                0, 0, 0, 0,
                // data offset
                54, 0, 0, 0,
        };
    }

    private byte[] getBitmapHeader() {
        int size = sizeX * sizeY * 3;

        return new byte[]{
                // header size
                40, 0, 0, 0,
                // bitmap width
                (byte) sizeX, (byte) (sizeX >>> 8), (byte) (sizeX >>> 16), (byte) (sizeX >>> 24),
                // bitmap height (positive: bottom-up)
                (byte) sizeY, (byte) (sizeY >>> 8), (byte) (sizeY >>> 16), (byte) (sizeY >>> 24),
                // planes (legacy)
                1, 0,
                // 24bit color-depth
                24, 0,
                // compression (disabled)
                0, 0, 0, 0,
                // image data size
                (byte) size, (byte) (size >>> 8), (byte) (size >>> 16), (byte) (size >>> 24),
                // pixels in X dimension per meter
                0, 0, 0, 0,
                // pixels in Y dimension per meter
                0, 0, 0, 0,
                // used color table
                0, 0, 0, 0,
                // important colors
                0, 0, 0, 0,
        };
    }

}
