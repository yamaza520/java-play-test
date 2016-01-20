package yamaza520.models;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import play.data.format.Formats;
import play.data.validation.Constraints;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Task extends Model {

    @Id
    public Long id;

    @Constraints.Required(message = "required")
    public String contents;

    @CreatedTimestamp
    @Formats.DateTime(pattern = "yyyy-MM-dd'T'HH:mm")
    public Date createdDate;

    @UpdatedTimestamp
    @Formats.DateTime(pattern = "yyyy-MM-dd'T'HH:mm")
    public Date updatedDate;

    public static Finder<Long, Task> find = new Finder<>(Task.class);

    public Task getById(Long id) {
        return find.byId(id);
    }

}
