import com.alibaba.fastjson.JSONObject;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2022/12/6 2:20 下午
 */
public class Video {

    public static void main(String[] args) throws FrameGrabber.Exception, ExecutionException, InterruptedException {
        doVideo();
    }

    private static void doVideo() throws InterruptedException, ExecutionException, FrameGrabber.Exception {
        //        String dir = "files/";
//        String pngPath = "";
        long startTime = System.currentTimeMillis();
        String videoPath = "/Users/chenhuichang/Downloads/12050常规媒介pro_guanzhaoya日常东联.mp4";
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(videoPath);

        ff.start();

        int ffLength = ff.getLengthInFrames();
        System.out.println("帧数："+ffLength);
        System.out.println("getLengthInFrames："+ff.getLengthInFrames());
        System.out.println("getFrameRate："+ff.getFrameRate());
        System.out.println("getLengthInTime："+ff.getLengthInTime());
        System.out.println("getLengthInVideoFrames："+ff.getLengthInVideoFrames());
        System.out.println("getVideoFrameRate："+ff.getVideoFrameRate());
        System.out.println("getMetadata："+ff.getMetadata());
        System.out.println("getVideoMetadata："+ff.getVideoMetadata());
        System.out.println("getDelayedTime："+ff.getDelayedTime());
        System.out.println("getTimeout："+ff.getTimeout());
        System.out.println("getTimestamp："+ff.getTimestamp());
        System.out.println("getFrameNumber："+ff.getFrameNumber());
        Frame f;
        int i = 1;
        ff.restart();
        while (i <= ffLength) {
//            ff.setTimestamp(10558100);
//            f = ff.grab();
            f = ff.grabImage();
            System.out.println("i："+i + "，" + (f == null ? "null" : ""));
            if(f == null || f.image == null) {
                ff.restart();
            }
            doExecuteFrame(f, "/Users/chenhuichang/Downloads/test/"+i+".png");

//            if((i>275)){
//                //生成图片的相对路径 例如：pic/uuid.png
//                String pngPath =  "/Users/chenhuichang/Downloads/12050常规媒介pro_guanzhaoya日常东联-275.png";
//                //执行截图并放入指定位置
//                doExecuteFrame(f, pngPath);
//            }

//            //截取第6帧
//            if((i>271) && (f.image != null)){
//                //生成图片的相对路径 例如：pic/uuid.png
//                String pngPath =  "/Users/chenhuichang/Downloads/12050常规媒介pro_guanzhaoya日常东联-275.png";
//                //执行截图并放入指定位置
//                doExecuteFrame(f, pngPath);
//                break;
//            }
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
