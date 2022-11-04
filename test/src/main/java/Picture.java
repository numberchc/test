import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Picture {

    private static Map<String, String> map;

    private static int BRANCH_FLAG = 1;

    static {
        map = new HashMap<>(10);
        map.put("500-2000", "0.5");
        map.put("2001-5000", "0.3");
        map.put("5001-10000", "0.2");
        map.put("10000-999999", "0.1");
    }


    public static void main(String[] args) throws Exception {
        long currentTime = System.currentTimeMillis();
        String path = "/Users/chenhuichang/Downloads/38126.jpg";
        File file = new File(path);

        BufferedImage srcImg = ImageIO.read(new FileInputStream(file));//使用imgeIO来读取图片
        ImageIO.write(srcImg, "png", new File("/Users/chenhuichang/Downloads/38126w.jpg"));//重新创建图片



//        Thumbnails.of(path).scale(0.8f).outputQuality(0.5f).keepAspectRatio(true).toFile("/Users/chenhuichang/Downloads/38126a.jpg");

//        Thumbnails.of(file)
//                .scale(1f) //图片大小（长宽）压缩比例 从0-1，1表示原图
//                .outputQuality(0.8f) //图片质量压缩比例 从0-1，越接近1质量越好
//                .toOutputStream(new FileOutputStream("/Users/chenhuichang/Downloads/38126a.jpg"));

        System.out.println("costTime =========" + (System.currentTimeMillis() - currentTime));


//
//       /* long fileSize = 401L;
//        float scale = getScale(fileSize);
//        System.out.println(Math.abs(scale-1.0F) != 0);*/
//        long currentTime = System.currentTimeMillis();
//        String path = "/Users/chenhuichang/Downloads/36809.jpg";
//        try {
//            File file = new File(path);
//            BufferedImage image = ImageIO.read(new FileInputStream(file));
//            long fileSize = file.length()/1024;
//            System.out.println("fileSize="+fileSize);
//            int width = image.getWidth();
//            int height = image.getHeight();
//            Double scale = 1.0D;
//
//            if (BRANCH_FLAG == 1) {
//                if (width >= 1024 && height >= 1024) {
////                    scale = getScale(width, height);
////                    System.out.println("scale=" + scale);
////
////                    width = (int) (width * scale);
////                    height = (int) (height * scale);
//                }
//            } else {
//                scale = getScale(fileSize);
//                System.out.println("scale=" + scale);
//                if (Math.abs(scale) != 0) {
//                    if (width >= 1024 && height >= 1024) {
//                        width = (int) (width * scale) < 1024 ? 1024 : (int) (width * scale);
//                        height = (int) (height * scale) < 1024 ? 1024 : (int) (height * scale);
//                    }
//                }
//            }
//            System.out.println("width=" + width);
//            System.out.println("height=" + height);
//            Thumbnails.of(path).size(width, height).keepAspectRatio(true).toFile("/Users/chenhuichang/Downloads/36809a.jpg");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long costTime = System.currentTimeMillis() - currentTime;
//        System.out.println("costTime =========" + costTime);
//

    }

    private static double getScale(int width, int height) {
        if (width < 1024) {
            return 1.0D;
        }
//        return Math.max(1024.0/width, 1024.0/height); 最小的边也是 1024
        return Math.min(1024.0/width, 1024.0/height); // 最大的边是 1024
    }

    private static Double getScale(long fileSize) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] keyArr = key.split("-");
            long begin = Long.parseLong(keyArr[0]);
            long end = Long.parseLong(keyArr[1]);
            if (fileSize > begin && fileSize < end) {
                return Double.parseDouble(map.get(key));
            }
        }
        return 0.0D;
    }

}