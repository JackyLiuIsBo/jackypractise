package design.structural.factorymethod;

/**
 * @ClassName EleExtentionFacde
 * @Description
 * @Author liubo
 * @Date 2021/7/3 10:56 下午
 **/
public class EleExtentionFacde implements ExtentionFace{
    @Override
    public Extention getExtention() {
        return new EleExtention();
    }
}
