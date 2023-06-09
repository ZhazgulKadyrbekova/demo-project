package crud.mvc.project.mapper;

import crud.mvc.project.entity.Operation;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.dto.OperationUpdateDto;

public interface OperationMapperService {
    OperationCreateDto mapToCreateDto(Operation operation);
    OperationUpdateDto mapToUpdateDto(Operation operation);
    OperationDto mapToDto(Operation operation);
}
