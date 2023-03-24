package models.handlers;

/**
 * Base interface for ModelHandler. Uses for building objects.
 *
 * @param <T> Type of building module.
 * @author zerumi
 * @since 1.0
 */
public interface ModuleHandler<T> {

    /**
     * Provides method to generate objects.
     *
     * @return Created object.
     */
    T buildObject();
}
