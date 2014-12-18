package org.nightschool.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 88888888 on 2014/12/6.
 */
public class Cart {

    private final List<Disks> disks = new ArrayList<>();
    private List<Disks> m_garbage = new ArrayList<Disks>();//垃圾箱

    public List<Disks> getDisks() {//ctrl+b进入函数
        return disks;
    }

    public void addDish(Disks disk) {
        disks.add(disk);
    }

    public int countKinds() {
        HashSet<Disks> hashSet = new HashSet<Disks>();

        for (Disks disk : disks){
            hashSet.add(disk);
        }
        return hashSet.size();
    }

    public void removeDisk(Disks disk) {
        int nCount = 0;

        for (Disks diskTemp : disks){
            if (diskTemp.equals(disk))
            {
                nCount++;
            }
        }

        int i = 0;
        while(i < nCount)
        {
            disks.remove(disk);
            ++i;
            //添加到垃圾箱
            m_garbage.add(disk);
        }
    }

    //恢复垃圾箱
    public void restoreGarbage() {
        int i = 0;
        int nCnt = m_garbage.size();

        while(i < nCnt){
            disks.add(m_garbage.get(0));
            ++i;
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Disks disk : disks){
            totalPrice += disk.getPrice();
        }
        return totalPrice;
    }
}
