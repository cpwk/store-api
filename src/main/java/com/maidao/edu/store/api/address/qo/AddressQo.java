package com.maidao.edu.store.api.address.qo;

import com.maidao.edu.store.common.reposiotry.support.DataQueryObjectSort;

public class AddressQo extends DataQueryObjectSort {

    protected String sortPropertyName = "def";
    protected boolean sortAscending = true;

    @Override
    public String getSortPropertyName() {
        return sortPropertyName;
    }

    @Override
    public void setSortPropertyName(String sortPropertyName) {
        this.sortPropertyName = sortPropertyName;
    }

    @Override
    public boolean isSortAscending() {
        return sortAscending;
    }

    @Override
    public void setSortAscending(boolean sortAscending) {
        this.sortAscending = sortAscending;
    }
}
