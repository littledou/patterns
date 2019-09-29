package cn.readsense.pattern.pproxy;

public class Samlpe1 {

    interface Image {
        void display();
    }

    class RealImage implements Image {

        String path;

        public RealImage(String path) {
            this.path = path;
        }

        @Override
        public void display() {

        }
    }
}
