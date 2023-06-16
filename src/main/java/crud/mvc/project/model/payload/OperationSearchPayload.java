package crud.mvc.project.model.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OperationSearchPayload {
    public int page = 1;

    @NotBlank(message = "Make sure to enter valid info to search")
    @NotNull(message = "Make sure to enter valid info to search")
    public String search;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
