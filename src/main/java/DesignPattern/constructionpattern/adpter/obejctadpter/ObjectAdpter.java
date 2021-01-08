package designpattern.constructionpattern.adpter.obejctadpter;

import designpattern.constructionpattern.adpter.Adptee;
import designpattern.constructionpattern.adpter.Target;

public class ObjectAdpter implements Target {
    private Adptee adptee;
    public ObjectAdpter(){
        adptee=new Adptee();
    }
    public ObjectAdpter(Adptee adptee){
        this.adptee=adptee;
    }
    @Override
    public void sayHi() {
        adptee.iSayHi();
    }
}
