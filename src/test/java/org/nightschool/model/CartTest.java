package org.nightschool.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by 88888888 on 2014/12/6.
 */
public class CartTest {

    private Cart cart;

    @Before//在test运行之前执行的函数
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void should_cart_be_empty_when_no_disk_added() throws Exception {//蛇形命名法
        List<Disks> disks = cart.getDisks();
        assertThat(disks.size(), is(0));
    }

    @Test
    public void should_be_able_to_add_disk_to_cart() throws Exception {
        Disks disk = new Disks();
        cart.addDish(disk);
        Cart cart = this.cart;//改成成员变量 ctrl+alt+f

        List<Disks> disks = cart.getDisks();
        assertThat(disks.size(),is(1));

    }

    @Test
    public void should_be_able_to_get_disk_properties() throws Exception {
        Disks disk1 = new Disks( "小清新光盘","./pics/disk/fancy-disk.jpg","小清新、小文艺 35元/10张");

        cart.addDish(disk1);

        Disks DiskTemp = cart.getDisks().get(0);
        assertThat(DiskTemp.getName(), is("小清新光盘"));
        assertThat(DiskTemp.getImg(), is("./pics/disk/fancy-disk.jpg"));
        assertThat(DiskTemp.getText(), is("小清新、小文艺 35元/10张"));
     }

    @Test
        public void should_be_able_to_count_kinks_of_disks () throws Exception{//不能计算重复的商品
        Disks disk1 = new Disks("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        Disks disk2 = new Disks("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cart.addDish(disk1);
        cart.addDish(disk1);
        cart.addDish(disk2);
        cart.addDish(disk1);

        assertThat(cart.countKinds(),is(2));
    }

    @Test
    public void should_be_able_to_remove_disk_from_cart() throws Exception {
        Disks disk1 = new Disks("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        Disks disk2 = new Disks("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cart.addDish(disk1);
        cart.addDish(disk2);
        cart.addDish(disk1);

        cart.removeDisk(disk1);
        assertThat(cart.getDisks().indexOf(disk1),is(-1));
    }

    @Test//回复垃圾箱测试
    public void should_be_able_to_restore_garbage() throws Exception {
        Disks disk1 = new Disks("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        Disks disk2 = new Disks("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cart.addDish(disk1);
        cart.addDish(disk2);
        cart.addDish(disk2);
        cart.addDish(disk2);
        cart.addDish(disk2);
        assertThat(cart.getDisks().size(),is(5));

        cart.removeDisk(disk2);
        assertThat(cart.getDisks().size(),is(1));

        cart.restoreGarbage();

        assertThat(cart.getDisks().size(),is(5));

    }

    @Test//计算总价
    public void should_be_able_to_count_total_price() throws Exception {
        Disks disk1 = new Disks("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        Disks disk2 = new Disks("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cart.addDish(disk1);
        cart.addDish(disk2);
        cart.addDish(disk2);

        assertThat(cart.getTotalPrice(),is(13.5));

    }
}
