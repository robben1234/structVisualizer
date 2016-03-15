package structvisualizer;
 /*
 * TypeValueFactory   3/15/16, 18:57
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Factory for values in output TextArea and in StackPane (animation) which returns value of the right type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TypeValueFactory {

    static String get(String type, int iteration) {

        switch (type) {
            case Types.INT:
                int intRes = 0;
                for (; intRes < iteration; intRes++) ;
                return "" + intRes;
            case Types.STRING:
                char strRes = 'a';
                for (int i = 0; i < iteration; i++) {
                    strRes++;
                }
                return "" + strRes;
            default:
                return "";
        }

    }
}
