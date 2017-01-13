package javacommon.base;

import com.sys.manager.model.LoginUser;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Andy
 * @since 2016/4/10
 */
public abstract class BaseSpringController<T> {

    @Inject
    protected MessageSource messageSource;

    protected abstract BaseManager<T> getManager();

    protected boolean validator(Map<String, Object> param) {
        return true;
    }

    protected LoginUser getLoginUser(HttpServletRequest request) {
        return (LoginUser)request.getAttribute("loginUser");
    }

    protected String getErrors(BindingResult br) {
        if (br.hasFieldErrors()) {
            StringBuilder msg = new StringBuilder();
            List<FieldError> fieldErrors = br.getFieldErrors();
            for (int i = 0; i < fieldErrors.size(); i++) {
                if (i > 0) {
                    msg.append(",");
                }
                msg.append(fieldErrors.get(i).getField()).append("\\s").append(fieldErrors.get(i).getDefaultMessage());
            }
            return msg.toString();
        }
        return null;
    }
}
