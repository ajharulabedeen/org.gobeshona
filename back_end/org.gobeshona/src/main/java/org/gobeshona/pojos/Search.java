/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.pojos;

/**
 *
 * @author Dell-3460
 */
public class Search
    {
        private String searchString;
        private String searchColumnName;

        public String getSearchString()
            {
            return searchString;
            }

        public void setSearchString(String searchString)
            {
            this.searchString = searchString;
            }

        public String getSearchColumnName()
            {
            return searchColumnName;
            }

        public void setSearchColumnName(String searchColumnName)
            {
            this.searchColumnName = searchColumnName;
            }
    }
