package crud.mvc.project.model.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OperationSearchPayload {
    public int page = 0;
    public int size = 5;

    @NotBlank(message = "Make sure to enter valid info to search")
    @NotNull(message = "Make sure to enter valid info to search")
    public String search;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
