
/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package search;

import java.awt.Point;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */

public class Heuristic implements IEstimatedCostFunction {

    public Integer x = 8;
    public Integer y = 4;

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoPlanta estado = (EstadoPlanta) node.getAgentState();

        // QUE BUSQUE MATAR EL ZOMBIE QUE ESTE MAS CERCA DE LA CASA
        if (estado.getZombies().size() > 0) {

            estado.getZombies().forEach((k, v) -> {

                if (x > k.x) {
                    x = k.x;
                    y = k.y;
                }
            });
            return Point.distance(x, y, estado.getPosicion().x, estado.getPosicion().y) - 1;
        } else {

            return 0;

        }

    }
}
