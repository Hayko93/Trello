package am.project.trello.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    D convertToDto(E entity);

    E convertToEntity(D dto);

    List<E> convertToEntityList(List<D> dto);

    List<D> convertToDtoList(List<E> entity);

}
