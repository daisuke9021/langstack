package jp.langstack.reverse.jpa;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class CustomReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

    private static final String CLASS_SUFFIX = "Entity";

    public CustomReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    // 生成されるエンティティのクラス名末尾に「Entity」を追加
    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
        return super.tableToClassName(tableIdentifier) + CLASS_SUFFIX;
    }

}