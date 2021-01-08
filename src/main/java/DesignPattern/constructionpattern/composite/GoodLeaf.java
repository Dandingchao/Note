package designpattern.constructionpattern.composite;

public class GoodLeaf implements Good{
    private Integer prices;
    private Integer num;
    @Override
    public Integer countPrice() {
        return prices*num;
    }
}
