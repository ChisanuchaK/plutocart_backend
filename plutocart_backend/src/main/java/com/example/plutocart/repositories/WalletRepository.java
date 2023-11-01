package com.example.plutocart.repositories;
import com.example.plutocart.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    // insert wallet
    @Transactional
    @Modifying
    @Query(value = "insert into  wallet (name_wallet , balance_wallet , account_id_account , create_wallet_on , update_wallet_on)" +
            " values(:name_wallet , :balance_wallet , :account_id_account , :create_wallet_on , :update_wallet_on)" , nativeQuery = true)
    void insertWalletByAccountID(String name_wallet , BigDecimal balance_wallet  , Integer account_id_account , LocalDateTime create_wallet_on , LocalDateTime update_wallet_on);

    @Transactional
    @Query(value = "select  name_wallet , balance_wallet from wallet where account_id_account = :account_id_account" , nativeQuery = true)
    List<Wallet> viewWalletByIdAccount(Integer account_id_account);

//    @Transactional
//    @Modifying
//    @Query(value = "update wallet set " , nativeQuery = true)
//    void
}
