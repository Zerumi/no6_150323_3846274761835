package models.handlers;

import models.Route;
import models.comparators.RouteComparator;
import models.validators.RouteValidator;
import models.validators.Validator;

import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Current implementation of CollectionsHandler for HashSet of Route.
 *
 * @since 1.0
 * @author Zerumi
 */
public class RoutesHandler implements CollectionHandler<HashSet<Route>, Route> {

    private static RoutesHandler singletoneMoment;

    private HashSet<Route> routes;
    private final Date initDate;

    private RoutesHandler() {
        routes = new HashSet<>();
        initDate = Date.from(Instant.now());
    }

    /**
     * Singletone moment.
     *
     * @return Single instance of handler.
     */
    public static RoutesHandler getInstance() {
        if (singletoneMoment == null)
            singletoneMoment = new RoutesHandler();
        return singletoneMoment;
    }

    /**
     * Returns actual collection reference.
     *
     * @return Current collection
     */
    @Override
    public HashSet<Route> getCollection()
    {
        return routes;
    }

    /**
     * Overrides current collection by provided value.
     *
     * @param routes Collection
     */
    @Override
    public void setCollection(HashSet<Route> routes) {
        this.routes = routes;
        validateElements();
        sort();
    }

    /**
     * Adds element to collection.
     *
     * @param e Element to add
     */
    @Override
    public void addElementToCollection(Route e)
    {
        routes.add(e);
        sort();
    }

    @Override
    public void clearCollection() {
        routes.clear();
    }

    /**
     * Sorts elements by ID Field in Route.
     */
    @Override
    public void sort() {
        HashSet<Route> sorted = new HashSet<>();

        for (Iterator<Route> it = routes.stream().sorted(new RouteComparator()).iterator(); it.hasNext(); ) {
            Route sortedItem = it.next();

            sorted.add(sortedItem);
        }

        this.routes = sorted;
    }

    /**
     * Returns first element of collection.
     * @return First element of collection. If collection is empty, returns new object.
     */
    @Override
    public Route getFirstOrNew()
    {
        if (routes.iterator().hasNext())
            return routes.iterator().next();
        else
            return new Route();
    }

    @Override
    public Date getInitDate() {
        return initDate;
    }

    /**
     * Returns last element of collection.
     * @return Last element of collection of null if collection is empty
     */
    @Override
    public Route getLastElement()
    {
        Route result = null;
        for (Route route : routes) {
            result = route;
        }
        return result;
    }

    /**
     * Validates all elements in collection
     */
    @Override
    public void validateElements() {
        HashSet<Long> ids = new HashSet<>(getCollection().size());

        for (Iterator<Route> it = getCollection().iterator(); it.hasNext(); ) {
            Route toValid = it.next();
            Validator<Route> validator = new RouteValidator();

            if (!validator.validate(toValid) || !ids.add(toValid.getId()))
            {
                it.remove();
                System.out.println("Element removed from collection: " + toValid);
                System.out.println("This element violates the restriction of some fields. Check your file and fix it manually.");
            }
        }
    }

    /**
     * Gets min element by given comparator
     *
     * @param comparator Comparator to compare.
     * @return Min element or null if collection is empty
     */
    @Override
    public Route getMin(Comparator<Route> comparator) {

        return getCollection().stream().min(comparator).orElse(null);
    }

    /**
     * Gets max element by given comparator
     *
     * @param comparator Comparator to compare.
     * @return Max element or null if collection is empty
     */
    @Override
    public Route getMax(Comparator<Route> comparator) {
        return getCollection().stream().max(comparator).orElse(null);
    }
}
