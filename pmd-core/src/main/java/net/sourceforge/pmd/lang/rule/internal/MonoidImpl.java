/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.rule.internal;

import java.util.Set;

import org.pcollections.HashTreePSet;
import org.pcollections.PSet;


@SuppressWarnings("unchecked")
final class MonoidImpl {

    static final Monoid PSET_MONOID = new Monoid<Set>() {
        @Override
        public Set apply(Set l, Set r) {
            if (l instanceof PSet) {
                return ((PSet) l).plusAll(r);
            } else if (r instanceof PSet) {
                return ((PSet) r).plusAll(l);
            }

            return HashTreePSet.from(l).plusAll(r);
        }

        @Override
        public Set zero() {
            return HashTreePSet.empty();
        }
    };

}
