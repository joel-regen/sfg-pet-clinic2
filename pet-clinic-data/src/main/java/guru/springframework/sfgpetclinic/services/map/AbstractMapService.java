package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map = new HashMap<>();
    private Long id = 0L;

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    public T findById(ID id){
        return map.get(id);
    }
    public T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(nextId());
            }
            map.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("object cannot be null");
        }
        return object;
    }
    public void deleteById(ID id){
        map.remove(id);
    }

    /**
     * removes all items from map that are equal to 'object'.
     */
    public void delete(T object){
//        map.entrySet().removeIf(object::equals);    // JT's implementation,
//          problem: No class found which is a subtype of both 'T' and 'Entry<Long, T>'

        map.values().removeIf(object::equals);    // JR's implementation - no problem
    }

    public Long nextId(){
        id++;
        return id;
    }
}
