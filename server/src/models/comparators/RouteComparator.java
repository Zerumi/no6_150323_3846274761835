package models.comparators;

import models.Route;

import java.util.Comparator;

/**
 * Compare two Routes by ID (default used)
 *
 * @author Zerumi
 * @since 1.0
 */
public class RouteComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
