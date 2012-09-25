package org.dynjs.runtime.builtins.types.regexp.prototype;

import org.dynjs.runtime.AbstractPrototypeFunction;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.GlobalObject;
import org.dynjs.runtime.JSObject;

public class ToString extends AbstractPrototypeFunction {

    public ToString(GlobalObject globalObject) {
        super(globalObject);
    }

    @Override
    public Object call(ExecutionContext context, Object self, Object... args) {
        JSObject jsSelf = (JSObject) self;
        
        StringBuffer str = new StringBuffer();
        str.append( "/" );
        str.append( jsSelf.get(context, "source"));
        str.append( "/" );
        
        if ( jsSelf.get(context, "global") == Boolean.TRUE ) {
            str.append( "g" );
        }
        
        if ( jsSelf.get(context, "ignoreCase") == Boolean.TRUE ) {
            str.append( "i" );
        }
        
        if ( jsSelf.get(context, "multiline") == Boolean.TRUE ) {
            str.append( "m" );
        }
        
        return str.toString();
        
    }

}
