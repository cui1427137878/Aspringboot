package service;

/**
 * ClassName:BuyGoodsService
 * Package:service
 * Description:
 *
 * @Data:2020/11/3 19:49
 * Author:崔建新
 */
public interface BuyGoodsService {
    //商品的编号，商品购买的数量
    void buy(Integer goodsId,Integer nums);
}
