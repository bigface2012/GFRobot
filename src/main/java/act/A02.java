package act;

import org.WindowEdit;
import util.CompareZone;
import util.NewFrame;

import javax.swing.*;
import java.util.Date;

public class A02 {
    public static void doA02(NewFrame frame) throws InterruptedException {
        WindowEdit.WindowEdit();
        CompareZone compareZone=new CompareZone();
        boolean flag=compareZone.toCompareZone("D:/key.png");
        System.out.println(flag);
        System.out.println(new Date());
        Thread.sleep(2000);
        frame.addInfo("完成");
    }
}
