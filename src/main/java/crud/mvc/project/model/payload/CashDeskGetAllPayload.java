package crud.mvc.project.model.payload;

public class CashDeskGetAllPayload {
    public int page = 0;
    public int size = 5;

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
}
