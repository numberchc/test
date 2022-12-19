import java.io.File;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2022/11/9 10:26 上午
 */
public class FileTest {

    public static void main(String[] args) {
        String path = "/Users/chenhuichang/Documents/东联/大曝光/素材中心/素材占比/整理版/全部元素111";
        File file = new File(path);
        System.out.println(file.isFile());
        System.out.println(file.listFiles());
        move(path, file);
    }

    private static void move(String path, File file) {
        try {
            if (file.isFile()) {
                String name = file.getName();
                if (name.contains("-")) {
                    name = name.replace(".png","");
                    StringBuffer newName = new StringBuffer();
                    String[] split = name.split("-");
                    newName.append(split[split.length - 1]);
                    for (int i = 0; i < split.length - 1; i++) {
                        newName.append("-" + split[i]);
                    }
                    name = newName + ".png";
                }
                file.renameTo(new File(path + "/" + name));
            } else {
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files != null || files.length > 0) {
                        for (File file1 : files) {
                            move(path, file1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
