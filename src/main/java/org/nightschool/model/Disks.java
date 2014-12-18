package org.nightschool.model;

/**
 * Created by 88888888 on 2014/12/6.
 */
public class Disks {
    private String m_strName;
    private String m_strImg;
    private String m_strText;
    private double m_fPrice;//单价

    Disks()
    {

    }
    Disks(String strName,String strImg,String strText)
    {
        m_strImg = strImg;
        m_strName = strName;
        m_strText = strText;
    }


    public String getName() {
        return m_strName;
    }

    public String getImg() {
        return m_strImg;
    }

    public String getText() {
        return m_strText;
    }

    public double getPrice() {
        m_fPrice = 0.0;
        if (m_strText.isEmpty())
        {
            return m_fPrice;
        }
        String strNum = m_strText.substring(m_strText.indexOf("/")+1,m_strText.indexOf("张"));
        int nNum = Integer.parseInt(strNum);

        if (nNum == 0)
        {
            return m_fPrice;
        }

        String strPrice = m_strText.substring(m_strText.indexOf(" ")+1,m_strText.indexOf("元"));
        double fPrice = Double.parseDouble(strPrice);

        if (fPrice == 0){
            return m_fPrice;
        }

        m_fPrice = fPrice/nNum;

        return m_fPrice;
    }
}
