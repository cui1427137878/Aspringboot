package service;

import com.sample.Goods;
import com.sample.Sale;
import dao.GoodsDao;
import dao.SaleDao;
import excep.NotEnoughException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:BuyGoodsServiceImpl
 * Package:service
 * Description:
 *
 * @Data:2020/11/3 20:12
 * Author:崔建新
 */
@Service("aa")
public class BuyGoodsServiceImpl implements BuyGoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SaleDao saleDao;
/*@Transactional(
        //加入事务后，销售表和库存表数据库操作同步，要成功都成功，要失败都失败
        propagation= Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        readOnly = false,
        rollbackFor = {NullPointerException.class,NotEnoughException.class,

        }
)*/
    @Transactional
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("方法的开始");
        //更新销售表Sale
        Sale sale=new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //更新库存Goods
        Goods goods= goodsDao.selectGoods(goodsId);
        if(goods==null){
            throw new NullPointerException("编号是"+goodsId+"的商品不存在");
        }else if(goods.getAmount()<nums){
            throw new NotEnoughException("编号是"+goodsId+"的商品库存不足");
        }
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
    }
}
