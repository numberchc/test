import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
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

//38126 报错
//39394 costTime =========28744
//40175 costTime =========4742
//39500 costTime =========13666
//41031 costTime =========5831

    public static void main(String[] args) throws Exception {
        long currentTime = System.currentTimeMillis();
        System.out.println(new BigDecimal(10).divide(new BigDecimal(21), 10, BigDecimal.ROUND_HALF_UP).doubleValue());


        File srcFile = new File("/Users/chenhuichang/Downloads/39500.jpg");
        File targetFile = new File("/Users/chenhuichang/Downloads/39500-new2.jpg");
        BufferedImage srcImg = ImageIO.read(new FileInputStream(srcFile));
        System.out.println(srcImg.getWidth());
        System.out.println(srcImg.getHeight());


//        FileInputStream fileInputStream = new FileInputStream("/Users/chenhuichang/Downloads/38126.jpg");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
//        byteArrayInputStream.read()
//        fileToByteArray(srcFile);

//        这种方式不行，报错：UnsupportedFormatException: No suitable ImageReader found for source data.
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Thumbnails.of(new ByteArrayInputStream(fileToByteArray(srcFile))).size(2560, 2560).toOutputStream(byteArrayOutputStream);
//        byteArrayToFile(byteArrayOutputStream.toByteArray(),targetFile);


//        Thumbnails.of(srcFile).size(2560, 2560).toFile(targetFile);
//        Thumbnails.of(srcFile).scale(0.5).toFile(targetFile);
//        Thumbnails.of(srcFile).scale(1).outputQuality(0.1).toFile(targetFile);
//        Thumbnails.of(srcFile).size(11906,9468).outputQuality(0.5).toFile(targetFile);

        System.out.println(srcFile.length()/1024/1024);
        System.out.println(targetFile.length()/1024/1024);
//        String srcPath = "/Users/chenhuichang/Downloads/38126.jpg";
//        File file = new File(srcPath);
//
//        BufferedImage srcImg = ImageIO.read(new FileInputStream(file));//使用imgeIO来读取图片
//        ImageIO.write(srcImg, "png", new File("/Users/chenhuichang/Downloads/38126w.jpg"));//重新创建图片
//


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




    public static byte[] fileToByteArray(File file){
        byte[] dest = null;
        InputStream ism = null;
        ByteArrayOutputStream baos = null;
        try {
            ism = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
//            read的返回值int是字符的值
//            int temp;
//            while((temp = ism.read())!=-1){
//                System.out.println((char)(temp));
//            }
            byte[] flush = new byte[1024*10];  //容器大小
            int length = -1;//接收长度
            while((length=ism.read(flush))!=-1){
                baos.write(flush,0,length);
            }
            baos.flush();
            dest = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ism!=null){
                    ism.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dest;
    }

    public static void byteArrayToFile(byte[] datas, File file ){
        InputStream is = null;
        OutputStream osm = null;
        try{
            is = new ByteArrayInputStream(datas);
            osm = new FileOutputStream(file);
            byte[] flush = new byte[1024];
            int len=-1;
            while((len=is.read(flush))!=-1){
                osm.write(flush,0,len);
            }
            osm.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(osm!=null){
                    osm.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}