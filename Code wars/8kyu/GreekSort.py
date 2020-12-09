greek_alphabet = (
    'alpha', 'beta', 'gamma', 'delta', 'epsilon', 'zeta', 
    'eta', 'theta', 'iota', 'kappa', 'lambda', 'mu', 
    'nu', 'xi', 'omicron', 'pi', 'rho', 'sigma',
    'tau', 'upsilon', 'phi', 'chi', 'psi', 'omega')

def greek_comparator(lhs, rhs):
    # the tuple greek_alphabet is defined in the global namespace
    if(lhs == rhs):
        return 0
    else:
        lhsIndex = [x for x in range(len(greek_alphabet)) if(greek_alphabet[x] == lhs) ] 
        rhsIndex = [x for x in range(len(greek_alphabet)) if(greek_alphabet[x] == rhs) ]
        return lhsIndex[0] - rhsIndex[0]


assert greek_comparator('alpha', 'beta') == 0
greek_comparator('psi', 'psi')  
greek_comparator('upsilon', 'rho')  
