package Service;

import Exceptions.TooYoungException;

public interface Reproducible {
    Object reproduce(Object offspring, String name) throws TooYoungException;
}
