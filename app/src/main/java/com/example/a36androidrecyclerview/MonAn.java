package com.example.a36androidrecyclerview;

import java.util.ArrayList;

public class MonAn
{
    public String tenMonan;
    public String diaChi;
    public Integer hinhAnh;

    public MonAn() {
    }

    public MonAn(String tenMonan, String diaChi, Integer hinhAnh) {
        this.tenMonan = tenMonan;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getTenMonan() {
        return tenMonan;
    }

    public void setTenMonan(String tenMonan) {
        this.tenMonan = tenMonan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Integer hinhAnh) {
        this.hinhAnh = hinhAnh;
    }




    public static ArrayList<MonAn> mock()
    {
        ArrayList<MonAn> mArraylistMonan = new ArrayList<>();
        mArraylistMonan.add(new MonAn("Bánh Huế Thu Thảo","61 Quang Trung, P. 10, Gò Vấp, TP. HCM",R.drawable.banhhuethuthao));
        mArraylistMonan.add(new MonAn("Bún đậu mẹc","376 Lê Văn Thọ, P. 11, Gò Vấp, TP. HCM",R.drawable.bundaumet));
        mArraylistMonan.add(new MonAn("Funfarm - Trái Cây Tô & Nước Ép","25/1 Giải Phóng, P. 4, Tân Bình, TP. HCM",R.drawable.funfarm));
        mArraylistMonan.add(new MonAn("Lava Coffee - Quang Trung","61 Quang Trung, P. 10, Gò Vấp, TP. HCM",R.drawable.lavacoffee));
        mArraylistMonan.add(new MonAn("Pizza Chảnh - Nguyễn Duy Cung","115/20 Nguyễn Duy Cung, Gò Vấp, TP. HCM",R.drawable.pizzachanh));
        return mArraylistMonan;
    }
}
