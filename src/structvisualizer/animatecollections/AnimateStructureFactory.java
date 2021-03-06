package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.data.Collections;
import structvisualizer.data.DataForValueFactory;

/**
 * Factory to pick right AnimateClass for input structure of data type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStructureFactory {
    /**
     * getter
     *
     * @param structName
     * @param methodName
     * @param typeName
     * @param canvas
     * @param obj SomeClass
     * @param input DataForValueFactory
     * @see SomeClass
     * @see DataForValueFactory
     * @return object of right type for input structure of data name
     */
    public static AnimateStructure get(String structName, String methodName, String typeName, Pane canvas, SomeClass
            obj, DataForValueFactory input) {

        switch (structName) {
            case Collections.ARRAY_LIST:
                return new AnimateArrayList(methodName, typeName, canvas, obj, input);
//            case Collections.HASH_MAP:
//                return new AnimateNothing(methodName, typeName, canvas, obj, input);
            case Collections.STACK:
                return new AnimateStack(methodName, typeName, canvas, obj, input);
//            case Collections.SET:
//                return new AnimateNothing(methodName, typeName, canvas, obj, input);
            default:
                return new AnimateNothing(methodName, typeName, canvas, obj, input);
        }
    }
}
