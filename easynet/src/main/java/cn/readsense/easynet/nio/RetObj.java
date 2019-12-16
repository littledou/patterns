package cn.readsense.easynet.nio;

public class RetObj {
    private float confidence;
    private String img1;
    private String img2;

    public RetObj(float confidence, String img1, String img2) {
        this.confidence = confidence;
        this.img1 = img1;
        this.img2 = img2;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
}
