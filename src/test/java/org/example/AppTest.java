package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    public void testTranspose() {
        // given
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // when
        int[][] newMatrix = App.transpose(matrix);

        // then
        assertThat(newMatrix).isDeepEqualTo(new int[][]{{1, 4}, {2, 5}, {3, 6}});
    }

    public void testRotate() {
        // given
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // when
        int[][] newMatrix = App.rotate(matrix);

        // then
        assertThat(newMatrix).isDeepEqualTo(new int[][]{{4, 1}, {5, 2}, {6, 3}});
    }
}
