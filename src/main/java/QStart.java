import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by aero on 3/14/16.
 */
public class QStart {

    public static void main(String[] args) {
        System.out.println("hello");
//        INDArray a = Nd4j.create(new float[]{1, 2}, new int[]{2, 1});
//        INDArray b = Nd4j.create(new float[]{ 3, 4}, new int[]{ 2});
        INDArray a = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{1, 2});
        INDArray b = Nd4j.create(new float[]{ 3, 4}, new int[]{2,1});
        System.out.println(a.mmul(b));
        System.out.println(b.mmul(a));
//        nd = nd.transpose();
//        System.out.println(nd);
//        System.out.println(nd.rows());
//        System.out.println(nd.columns());


    }

}
