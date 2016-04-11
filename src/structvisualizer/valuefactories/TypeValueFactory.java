package structvisualizer.valuefactories;

import structvisualizer.animatecollections.animatemethods.DataForValueFactory;
import structvisualizer.data.DataForAnimation;
import structvisualizer.data.Types;
import structvisualizer.valuefactories.TooltipValueFactory;

import java.util.List;
import java.util.Random;

/**
 * Factory for values in output TextArea and in StackPane (animation) which returns value of the right type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TypeValueFactory {
    static DataForAnimation data = new DataForAnimation();

    public static String get(String type, DataForValueFactory d) {
        return get(type, d.getIteration(), d.isRand(), d.getIterations(), d.isWrite());
    }

    /**
     * @param type
     * @param iteration
     *
     * @return
     */
    public static String get(String type, int iteration, boolean rand, List<Integer> iterations, boolean write) {

        if(rand) {
            if(write) {
                Random random = new Random();
                iteration = random.nextInt(data.getMaxIteration());
                iterations.add(iteration);
            } else {
                iteration = iterations.get(iteration);
            }
        }

        switch (type) {
            case Types.INT:
                return "" + iteration;
            case Types.STRING:
                return TooltipValueFactory.getStringValue(iteration);
            case Types.SOME_CLASS:
                StringBuilder scRes = new StringBuilder("obj").append(iteration);
                return scRes.toString();
            case Types.CUSTOM:
                StringBuilder cRes = new StringBuilder("obj").append(iteration);
                return cRes.toString();
            default:
                return "";
        }

    }
}
