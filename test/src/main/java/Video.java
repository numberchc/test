import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2022/12/6 2:20 下午
 */
public class Video {

    public static void main(String[] args) throws FrameGrabber.Exception {
//        String dir = "files/";
//        String pngPath = "";
        long startTime = System.currentTimeMillis();
        String videoPath = "/Users/chenhuichang/Downloads/43776常规媒介京东小时购-测试账号日常东联.mp4";
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(videoPath);

        ff.start();
        int ffLength = ff.getLengthInFrames();
        System.out.println("帧数："+ffLength);
        Frame f;
        int i = 0;
        while (i < ffLength) {
            f = ff.grabImage();
            //截取第6帧
            if((i>675) &&  (f.image != null)){
                //生成图片的相对路径 例如：pic/uuid.png
                String pngPath =  "/Users/chenhuichang/Downloads/43776常规媒介京东小时购-测试账号日常东联.png";
                //执行截图并放入指定位置
                doExecuteFrame(f, pngPath);
                break;
            }
            i++;
        }
        ff.stop();
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));
    }

    /**
     * 截取缩略图
     * @param f Frame
     * @param targerFilePath:封面图片存放路径
     */
    private static void doExecuteFrame(Frame f, String targerFilePath) {
        String imagemat = "png";
        if (null == f || null == f.image) {
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bi = converter.getBufferedImage(f);
        File output = new File(targerFilePath);
        try {
            ImageIO.write(bi, imagemat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
