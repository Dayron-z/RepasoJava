package Interface;

import java.util.List;

public interface CRUD {

    public  Object insertAuthor(Object obj);

    public List<Object> showAuthor();

    public boolean update(Object obj);

    public boolean delete(Object obj);



}
