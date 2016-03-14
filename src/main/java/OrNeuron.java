import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.conditions.Condition;
import org.nd4j.linalg.indexing.conditions.GreaterThanOrEqual;

/**
 * Created by aero on 3/14/16.
 */
public class OrNeuron {


    public static void main(String[] args) {

        INDArray weights = Nd4j.create(new double[]{0.01, 0.02, 0.03}, new int[]{3, 1});
        System.out.println(weights);

        final INDArray inputs = Nd4j.create(new float[]{0, 0, 0, 1, 1, 0, 1, 1}, new int[]{4, 2});
        System.out.println(inputs);

        final INDArray targets = Nd4j.create(new float[]{0, 1, 1, 1}, new int[]{4, 1});
        System.out.println(targets);

        INDArray outputs = calculateOutputs(inputs, weights);
        System.out.println("fist outs");
        System.out.println(outputs);

        INDArray corrections = calculateWeightsCorrections(0.1, inputs, outputs, targets);
        weights = weights.add(corrections.transpose());
        System.out.println("weights");
        System.out.println(weights);
        outputs = calculateOutputs(inputs, weights);
        System.out.println("second outs");
        System.out.println(outputs);

        corrections = calculateWeightsCorrections(0.1, inputs, outputs, targets);
        weights = weights.add(corrections.transpose());
        System.out.println("weights");
        System.out.println(weights);
        outputs = calculateOutputs(inputs, weights);
        System.out.println("third outs");
        System.out.println(outputs);

        corrections = calculateWeightsCorrections(0.1, inputs, outputs, targets);
        weights = weights.add(corrections.transpose());
        System.out.println("weights");
        System.out.println(weights);
        outputs = calculateOutputs(inputs, weights);
        System.out.println("fourth outs");
        System.out.println(outputs);
    }

    public static INDArray calculateWeightsCorrections(double nu,
                                                       INDArray inputs,
                                                       INDArray outputs,
                                                       INDArray targets) {
        System.out.println("outs");
        System.out.println(outputs);
        //t - outputs
        INDArray mistake = targets.sub(outputs);
        System.out.println("mistake");
        System.out.println(mistake);
        System.out.println(mistake.transpose().isRowVector());

        // mistake * inputs
        inputs = Nd4j.append(inputs,1,-1,1);
        INDArray mistByInputs = mistake.transpose().mmul(inputs).mul(nu);
        System.out.println("mst by inputs");
        System.out.println(mistByInputs);

        return mistByInputs;
    }

    public static INDArray calculateOutputs(INDArray inputs, INDArray weights) {

        inputs = Nd4j.append(inputs,1,-1,1);
        return inputs.mmul(weights).cond(new GreaterThanOrEqual(0));
    }

}
