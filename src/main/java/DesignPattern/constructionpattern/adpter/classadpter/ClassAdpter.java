package designpattern.constructionpattern.adpter.classadpter;

import designpattern.constructionpattern.adpter.Adptee;
import designpattern.constructionpattern.adpter.Target;

public class ClassAdpter extends Adptee implements Target {

    @Override
    public void sayHi() {
        iSayHi();
    }
}
